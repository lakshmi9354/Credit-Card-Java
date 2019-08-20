package com.ing.creditcardpayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ing.creditcardpayment.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public	User findByMobileNoAndPassword(String mobileNo, String password);
	@Query(value = "select c.* from customer c where customer_id =:customerId",nativeQuery = true)
	public User findByCustomerId(@Param("customerId") Integer customerId);

}
