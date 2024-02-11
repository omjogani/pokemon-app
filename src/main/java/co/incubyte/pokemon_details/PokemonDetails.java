package co.incubyte.pokemon_details;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "pokemon_detail")
public class PokemonDetails {
    @Id
    private String id;

    private String name;

    private String url;

    private int height;
    private int weight;

    public PokemonDetails() {
    }

    public PokemonDetails(String id, String name, String url, int height, int weight) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.height = height;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
