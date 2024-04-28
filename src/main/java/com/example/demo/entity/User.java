package com.example.demo.entity;

import com.example.demo.entity.enums.TipoUserPermission;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do usuário é obrigatório.")
    @Size(min = 3, max = 50, message = "O nome do usuário deve ter entre 3 e 50 caracteres.")
    private String nameUser;

    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "O email fornecido não é válido.")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "A senha é obrigatória.")
    @Size(min = 6, max = 100, message = "A senha deve ter entre 6 e 100 caracteres.")
    private String password;

    @NotNull(message = "A permissão do usuário é obrigatória.")
    private TipoUserPermission tipoUserPermission;

    
    public String getNameUser() {
        return nameUser;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    public TipoUserPermission getTipoUserPermission() {
        return tipoUserPermission;
    }

    // Método Builder

    public static class Builder {
        private final User user;

        public Builder() {
            this.user = new User();
        }

        public Builder id(Long id) {
            this.user.id = id;
            return this;
        }

        public Builder nameUser(String nameUser) {
            this.user.nameUser = nameUser;
            return this;
        }

        public Builder email(String email) {
            this.user.email = email;
            return this;
        }

        public Builder password(String password) {
            this.user.password = password;
            return this;
        }

        public Builder tipoUserPermission(TipoUserPermission tipoUserPermission){
            this.user.tipoUserPermission = tipoUserPermission;
            return this;
        }

        public User build() {
            return user;
        }
    }

    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }



}
