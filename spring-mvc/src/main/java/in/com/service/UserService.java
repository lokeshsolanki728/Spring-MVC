package in.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.com.dao.UserDAO;
import in.com.dto.UserDTO;

@Service
public class UserService {
	@Autowired
	UserDAO dao;

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDTO dto) {
		long pk = dao.add(dto);
		return pk;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDTO dto) {
		dao.update(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(UserDTO dto) {
		dao.delete(dto);

	}

	@Transactional(readOnly = true)
	public UserDTO findByPk(long pk) {
		return dao.findByPk(pk);
	}
	@Transactional(readOnly = true)
	public UserDTO auth(String login, String pass) {
		return dao.authenticate(login, pass);
		
	}

	@Transactional(readOnly = true)
	public UserDTO findByLogin(String login) {
		return dao.findByLogin(login);
	}
	@Transactional(readOnly = true)
	public List search(UserDTO dto) {
		return dao.search(dto);
	}
	@Transactional(readOnly = true)
	public List search(UserDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}

}
