package pl.project.internalcloudservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class EurekaUser {

    @Id
    @GeneratedValue
    private Long id;

    private String userName;
    private String realName;
    private String lastName;
}
