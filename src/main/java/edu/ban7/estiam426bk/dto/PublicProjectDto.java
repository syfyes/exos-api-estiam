package edu.ban7.estiam426bk.dto;

import edu.ban7.estiam426bk.model.Image;
import edu.ban7.estiam426bk.model.Project;

import java.util.List;

/**
 * DTO d'un projet public : uniquement l'id, le nom et les URL des images.
 * Aucune référence vers les entités -> pas de JSON infini.
 */
public record PublicProjectDto(Integer id, String name, List<String> imageUrls) {

    public static PublicProjectDto fromEntity(Project project) {
        return new PublicProjectDto(
                project.getId(),
                project.getName(),
                project.getImages().stream().map(Image::getUrl).toList());
    }
}
