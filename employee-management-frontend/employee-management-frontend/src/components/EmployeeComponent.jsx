import React, { useEffect, useState } from 'react'
import { createEmployee,getEmployeeById } from '../services/EmployeeService'
import{useNavigate, useParams} from 'react-router-dom';
const EmployeeComponent = () => {


    const [firstName, setFirstName] = useState('')
    const [lastName, setLastName] = useState('')
    const [email, setEmail] = useState('')

    const [errors, setErrors] = useState({
        firstName:'',
        lastName:'',
        email:''

    })

    function handleFirstName(e){
        setFirstName(e.target.value);
    }
    function handleLastName(e){
        setLastName(e.target.value);
    }
    function handleEmail(e){
        setEmail(e.target.value);
    }


    const navigator = useNavigate();

    //for update web page to get the data
    // useEffect(() => {

    //     if(id){
    //         getEmployeeById(id).then((response) =>{
    //             setFirstName(response.data.firstName)
    //             setLastName(response.data.lastName)
    //             setEmail(response.data.email)
    //         }).catch(error => {
    //             console.log(error)
    //         })
    //     }

    // }, [id])


    function saveEmployee(e){
        e.preventDefault();

        if(validateForm()){

            const employee = {firstName, lastName, email}
            console.log(employee)

            createEmployee(employee).then((response)=>{
                console.log(response.data);
                navigator('/employees')
            })

        }

    }
    function validateForm(){
        let valid = true;
        const errorsCopy = {... errors}

        if(firstName.trim()){
            errorsCopy.firstName = '';
        }else{
            errorsCopy.firstName='First name is required';
            valid = false;
        }

        if(lastName.trim()){
            errorsCopy.lastName = '';
        }else{
            errorsCopy.lastName = 'Last name is required';
            valid = false;
        }
        if(email.trim()){
            errorsCopy.email = '';
        }else{
            errorsCopy.email = 'email is required';
            valid = false;
        }

        setErrors(errorsCopy);
        return valid
    }

    const {id} = useParams();

    const pageTitle = () => {

        if(id){
            return <h2 className = "text-center">Update Employee</h2>
        }else{
            return <h2 className = "text-center">Add Employee</h2>
        }
    }

  return (
    <div className='container'>
    <div className='row'>
        <div className='card'>
        {
            pageTitle()
        }
        <div className='card-body'>
            <form>
                <div className='form-group mb-2'>
                    <label className='form-label'>Employee First Name: </label>
                    <input
                        type='text'
                        placeholder='Enter employee first name'
                        name='firstName'
                        value={firstName}
                        className={`form-control ${errors.firstName ? 'is-invalid':''}`}
                        onChange={handleFirstName}>
                    </input>
                    {errors.firstName && <div className='invalid-feedback'>{errors.firstName}</div>}
                </div>
                <div className='form-group mb-2'>
                    <label className='form-label'>Employee Last Name: </label>
                    <input
                        type='text'
                        placeholder='Enter employee last name'
                        name='lastName'
                        value={lastName}
                        className={`form-control ${errors.lastName ? 'is-invalid':''}`}
                        onChange={handleLastName}>
                    </input>
                    {errors.lastName && <div className='invalid-feedback'>{errors.lastName}</div>}
                </div>
                <div className='form-group mb-2'>
                    <label className='form-label'>Employee Email: </label>
                    <input
                        type='text'
                        placeholder='Enter employee email'
                        name='email'
                        value={email}
                        className={`form-control ${errors.email ? 'is-invalid':''}`}
                        onChange={handleEmail}>
                    </input>
                    {errors.email && <div className='invalid-feedback'>{errors.email}</div>}
                </div>

                <button className='btn btn-success' onClick={saveEmployee}>Submit</button>
            </form>
        </div>

        </div>
    </div>

    </div>
  )
}

export default EmployeeComponent
