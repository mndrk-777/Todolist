package br.com.lucascarvalho.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_tasks")
public class TaskModel {
    /**
     *
     * ID
     * USUARIO (iD_USUARIO)
     * DESCRIÇAO
     * TITULO
     * DATA DE INICIO
     * DATA DE TERMINO
     * PRIORIDADE
     */

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String description;

    @Column(length = 50)
    private String title;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String priority;
    private UUID idUser;

    @CreationTimestamp
    private LocalDateTime createAt;

    public void setTitle(String title) throws Exception {
        if (title.length() > 50) {
            throw new Exception("O CAMPO TITLE SO PERMITE 50 CARACTERES");
        }
        this.title = title;
    }

}