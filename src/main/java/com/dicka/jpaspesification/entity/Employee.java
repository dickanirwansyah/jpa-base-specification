package com.dicka.jpaspesification.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author dickanirwansyah
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee extends BaseEntity{
    
    @Column(name = "full_name")
    private String fullName;
    
    @Column(name = "position")
    private String position;
    
    @Column(name = "salary")
    private BigDecimal salary;
    
    @Column(name = "dob")
    private Date dob;
    
    @Column(name = "level")
    private String level;
}
