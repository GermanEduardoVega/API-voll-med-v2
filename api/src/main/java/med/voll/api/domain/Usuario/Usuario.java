package med.voll.api.domain.Usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Usuario")    //Para que se genere la tabla en la base de datos
@Table(name = "usuarios")
@Getter //metodos getter se generan en tiempo de compilacion
@NoArgsConstructor  //constructor sin argumentos
@AllArgsConstructor //constructor con todos los argumentos
@EqualsAndHashCode(of = "id")   //identifica que campos son iguales es decir que objetos si el id es igual
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Para que se genere el id por defecto en la base de datos
    private Long id;
    private String login;
    private String senha;
}
