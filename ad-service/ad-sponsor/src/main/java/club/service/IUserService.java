package club.service;


import club.codezp.exception.AdException;
import club.vo.CreateUserRequest;
import club.vo.CreateUserResponse;

/**
 *
 */
public interface IUserService {

    /**
     * <h2>创建用户</h2>
     * */
    CreateUserResponse createUser(CreateUserRequest request)
            throws AdException;
}
