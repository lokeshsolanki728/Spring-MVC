package in.com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.com.dto.UserDTO;

@Repository
public class UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	public long add(UserDTO dto) {
		Long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	public void delete(UserDTO dto) {
		sessionFactory.getCurrentSession().delete(dto);
	}

	public void update(UserDTO dto) {
		sessionFactory.getCurrentSession().update(dto);
	}

	public UserDTO findByPk(long pk) {
		UserDTO dto = sessionFactory.getCurrentSession().get(UserDTO.class, pk);
		return dto;

	}

	public UserDTO findByLogin(String login) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(UserDTO.class);
		c.add(Restrictions.ilike("loginId", login));
		List<UserDTO> list = c.list();
		UserDTO dto = null;
		if (list != null) {
			dto = list.get(0);
		}
		return dto;
	}

	public UserDTO authenticate(String login, String password) {
		UserDTO dto = null;
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(UserDTO.class);
		criteria.add(Restrictions.eq("loginId", login));
		criteria.add(Restrictions.eq("password", password));
		List list = criteria.list();
		if (list.size() == 1) {
			dto = (UserDTO) list.get(0);
		}
		return dto;
	}

	public List search(UserDTO dto) {
		return search(dto, 0, 0);
	}

	public List search(UserDTO dto, int pageNo, int pageSize) {

		Criteria c = sessionFactory.getCurrentSession().createCriteria(UserDTO.class);
		if (dto != null) {
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				c.add(Restrictions.ilike("firstName", dto.getFirstName() + "%"));
			}
			if (dto.getLastName() != null && dto.getLastName().length() > 0) {
				c.add(Restrictions.ilike("lastName", dto.getLastName() + "%"));
			}
			if (dto.getLoginId() != null && dto.getLoginId().length() > 0) {
				c.add(Restrictions.ilike("loginId", dto.getLoginId() + "%"));
			}
			if (dto.getPassword() != null && dto.getPassword().length() > 0) {
				c.add(Restrictions.ilike("password", dto.getPassword() + "%"));
			}
			if (dto.getAddress() != null && dto.getAddress().length() > 0) {
				c.add(Restrictions.ilike("address", dto.getAddress() + "%"));
			}
			if (dto.getDob() != null && dto.getDob().getTime() > 0) {
				c.add(Restrictions.eq("dob", new java.sql.Date(dto.getDob().getTime()) + "%"));
			}

		}
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			c.setFirstResult(pageNo);
			c.setMaxResults(pageSize);
		}

		List list = c.list();

		return list;
	}
}
