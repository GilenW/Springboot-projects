package gil.todo_management.service;

import gil.todo_management.dto.LoginDto;
import gil.todo_management.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);

    String login(LoginDto loginDto);
}
