package jjafact.hash.business.entity.item;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class ItemImage {

    @Id @GeneratedValue
    private Long id;

    @Comment("이미지 경로")
    private String path;

    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;

    @Comment("활성화 여부 1: 활성화 / 0 :비활성화")
    private String isView;

    @Builder
    public ItemImage(String path, Item item, String isView) {
        this.path = path;
        this.item = item;
        this.isView = isView;
    }

    public static ItemImage create(Item item,String path){
        return builder()
                .item(item)
                .path(path)
                .isView("!")
                .build();
    }
}
