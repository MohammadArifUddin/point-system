package com.example.pointsystem.repositories;

import com.example.pointsystem.models.entities.Payment;
import com.example.pointsystem.payload.response.GetSalesProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query("SELECT function('date_format', p.createdAt, '%Y-%m-%d') AS datetime, SUM(p.paidAmount) AS sales, SUM(p.pointAmount) AS points  "
            + "FROM Payment as p where p.createdAt BETWEEN :startDate AND :endDate GROUP BY datetime")
    List<GetSalesProjection> findByDate(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

}
