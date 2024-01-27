package org.enes.service;

import lombok.RequiredArgsConstructor;
import org.enes.dto.request.LoginRequestDto;
import org.enes.dto.request.RegisterRequestDto;
import org.enes.dto.response.LoginResponseDto;
import org.enes.dto.response.RegisterResponseDto;
import org.enes.entity.User;
import org.enes.mapper.UserMapper;
import org.enes.repository.UserRepository;
import org.enes.utility.EStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

@Service
@RequiredArgsConstructor
public class UserService implements ICrudService<User, Long> {
    private final UserRepository userRepository;


    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            return user;
        }else {
            throw new NullPointerException("Kullanıcı Bulunamadı.");
        }
    }

    @Override
    public List<User> findAll() {
        List<User> userList = userRepository.findAll();
        if (userList.isEmpty()){
            throw new NullPointerException("Liste Boş.");
        }
        return userList;
    }

    @Override
    public User deleteById(Long id) {
        Optional<User> user=findById(id);
        if (user.isPresent()){
            user.get().setStatus(EStatus.INACTIVE);
            return userRepository.save(user.get());
        }else {
            throw new NullPointerException("Kullanıcı Bulunamadı.");
        }
    }

    public User register(String name,String surname,String email,String password,String rePassword){
        User user=User.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .rePassword(rePassword)
                .build();
        // " " -> isBlank = true, " " isEmpty = false çünkü boşlukta bir karakter
        if (!password.equals(rePassword) || password.isBlank()){
            throw new RuntimeException("Şifreler aynı değildir.");
        }

        return userRepository.save(user);
    }

    public User login(String email, String password){
        Optional<User> user = userRepository.findByEmailAndPassword(email, password);
        if (user.isEmpty()){
            throw  new RuntimeException("Kullanıcı bilgileri yanlış.");
        }
        return user.get();
    }

    public RegisterResponseDto registerDto(RegisterRequestDto dto) {
        User user=User.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .rePassword(dto.getRePassword())
                .build();
        if (!user.getPassword().equals(user.getRePassword()) || user.getPassword().isBlank()){
            throw new RuntimeException("Şifreler aynı değildir.");
        }
        userRepository.save(user);
        return RegisterResponseDto.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .status(user.getStatus())
                .build();
    } // katmanların request dto - entity - response dto şeklinde birbirleri ile ilişkili olması gerekiyor.

    public RegisterResponseDto registerMapper(RegisterRequestDto dto) {
        User user = UserMapper.INSTANCE.fromRegisterRequestDtoToUser(dto);
        if (!user.getPassword().equals(user.getRePassword()) || user.getPassword().isBlank()){
            throw new RuntimeException("Şifreler aynı değildir.");
        }
        userRepository.save(user);
        return UserMapper.INSTANCE.fromUserDtoToRegisterResponse(user);
    }

    public LoginResponseDto loginDto(LoginRequestDto dto) {
        Optional<User> user = userRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (user.isEmpty()){
            throw  new RuntimeException("Kullanıcı bilgileri yanlış.");
        }
        return LoginResponseDto.builder()
                .email(user.get().getEmail())
                .welcome("Merhaba film uygulamasına başarıyla giriş yaptınız")
                .build();
    }

    public LoginResponseDto loginMapper(LoginRequestDto dto) {
        Optional<User> user = userRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (user.isEmpty()){
            throw  new RuntimeException("Kullanıcı bilgileri yanlış.");
        }
        return UserMapper.INSTANCE.fromUserToLoginResponseDto(user.get());
    }

    public List<User> findAllByOrderByName() {
        List<User> userList = userRepository.findAllByOrderByName();
        if (userList.isEmpty()){
            throw new NullPointerException("Liste Boş.");
        }
        return userList;
    }

    public boolean existsByName(String name){
        return userRepository.existsByNameContainingIgnoreCase(name);
    }

    public List<RegisterResponseDto> findByNameContaining(String name){
        List<User> userList = userRepository.findAllByNameContainingIgnoreCase(name);
        if (userList.isEmpty()){
            throw new NullPointerException("Liste Boş.");
        }
        return UserMapper.INSTANCE.fromUserListToRegisterResponseDtoList(userList);
    }

    public Optional<RegisterResponseDto> findByEmail(String email){
        Optional<User> user = userRepository.findByEmailIgnoreCase(email);
        if (user.isEmpty()){
            throw new NullPointerException("Kullanıcı Bulunamadı.");
        }
        return Optional.ofNullable(UserMapper.INSTANCE.fromUserDtoToRegisterResponse(user.get()));

    }
}
