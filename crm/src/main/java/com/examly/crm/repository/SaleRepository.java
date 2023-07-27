package com.examly.crm.repository;

// import com.examly.crm.graphentity.MonthAmount;
import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.crm.model.Sale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Year;
import java.util.List;
import java.util.Map;

public interface SaleRepository extends JpaRepository<Sale,Long>{

    @Query(value = "SELECT MONTH(date) AS month, SUM(amount) AS total_amount FROM sale WHERE YEAR(date) = YEAR(CURRENT_DATE()) " +
            "AND name='Furniture' GROUP BY MONTH(date) ORDER BY MONTH(date)",
            nativeQuery = true)
    List<Map<String, Object>> getDetails();

    @Query(value = "SELECT MONTH(date) AS month, SUM(amount) AS total_amount FROM sale WHERE YEAR(date) = YEAR(CURRENT_DATE()) " +
            "AND name='clothing' GROUP BY MONTH(date) ORDER BY MONTH(date)",
            nativeQuery = true)
    List<Map<String, Object>> getDetailsclothing();

    @Query(value = "SELECT MONTH(date) AS month, SUM(amount) AS total_amount FROM sale WHERE YEAR(date) = YEAR(CURRENT_DATE()) " +
            "AND name='Electronics' GROUP BY MONTH(date) ORDER BY MONTH(date)",
            nativeQuery = true)
    List<Map<String, Object>> getDetailsElectronics();

    @Query(value = "SELECT MONTH(date) AS month, SUM(amount) AS total_amount FROM sale WHERE YEAR(date) = YEAR(CURRENT_DATE()) " +
            "AND name='HealthProducts' GROUP BY MONTH(date) ORDER BY MONTH(date)",
            nativeQuery = true)
    List<Map<String, Object>> getDetailsHealthProducts();

}
