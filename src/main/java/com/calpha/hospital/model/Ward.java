package com.calpha.hospital.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;


/**
*
* @author CAlpha
*/
@Builder
@Entity
@Table(name="ward")
public class Ward implements Serializable {
   
	private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="wardId")
   private Long wardId;
           
   @Column(name="wardCode")
    private String wardCode;
   
   @Column(name="wardDescription")
    private String wardDescription;
   
   
}
