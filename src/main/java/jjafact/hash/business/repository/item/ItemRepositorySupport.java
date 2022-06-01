package jjafact.hash.business.repository.item;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jjafact.hash.business.dto.ItemDto;
import jjafact.hash.business.entity.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static jjafact.hash.business.entity.item.QItem.item;

@RequiredArgsConstructor
@Repository
public class ItemRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public Page<ItemDto> findItems(Pageable pageable){
        List<ItemDto> results = queryFactory.select(Projections.constructor(ItemDto.class, item))
                .from(item)
                .where(item.id.isNotNull(), betweenDate())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(item.createDate.desc())
                .fetch();

        int totalCount = queryFactory.select(Projections.constructor(Item.class,item)).from(item)
                .where(item.id.isNotNull(),betweenDate())
                .fetch().size();

        return new PageImpl<>(results,pageable,totalCount);
    }

    private BooleanExpression query(String query){
        if (query == null) return null;
        return item.name.contains(query);
    }

    private BooleanExpression betweenDate(){
        LocalDateTime startDate = LocalDateTime.of(LocalDate.now(), LocalTime.of(0,0,0));
        LocalDateTime endDate = LocalDateTime.of(LocalDate.now(), LocalTime.of(23,59,59));

        return item.createDate.between(startDate,endDate);
    }
}
