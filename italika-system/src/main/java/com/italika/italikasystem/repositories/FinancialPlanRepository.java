package com.italika.italikasystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.italika.italikasystem.models.FinancialPlan;

@Repository
public interface FinancialPlanRepository extends JpaRepository<FinancialPlan, Long>{

}
