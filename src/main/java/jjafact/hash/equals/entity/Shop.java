package jjafact.hash.equals.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Shop {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String phone;
    private String location;
}
