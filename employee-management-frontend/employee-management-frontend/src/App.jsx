
import './App.css'
import HelloWorld from './HelloWorld'
import EmployeeComponent from './components/EmployeeComponent'
import HeaderComponent from './components/HeaderComponent'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import {BrowserRouter, Routes,Route} from 'react-router-dom'

function App() {

  return (
    <>
    <BrowserRouter>
      <HeaderComponent/>
      <Routes>
        <Route path='/' element={<ListEmployeeComponent/>}></Route>
        <Route path='/employees' element={<ListEmployeeComponent/>}></Route>


        <Route path='/add-employee' element={<EmployeeComponent/>}></Route>

        <Route path = "/edit-employee/:id" element = { <EmployeeComponent />}></Route>

      </Routes>
    </BrowserRouter>


    </>
  )
}

export default App
