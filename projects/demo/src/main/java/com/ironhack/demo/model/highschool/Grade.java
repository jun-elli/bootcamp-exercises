package com.ironhack.demo.model.highschool;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Grade {
   @Id
   @GeneratedValue
   private Integer id;

   private Integer courseClassId;

   private float score;
}
