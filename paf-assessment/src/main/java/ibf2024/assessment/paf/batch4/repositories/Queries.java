package ibf2024.assessment.paf.batch4.repositories;

public interface Queries {
    public static final String BEER_STYLE_COUNT = """
            select s.id, s.style_name, count(b.id) cnt_beers
            from styles s
            left join beers b
            on b.style_id = s.id
            where style_name is not null
            group by 1,2
            order by cnt_beers desc, style_name asc;
            """;

    public static final String BEER_BREWERIES = """
            select b.id beer_id, b.name beer_name, b.descript beer_description, br.id brewery_id, br.name brewery_name
            from beers b
            left join styles s
            on b.style_id = s.id
            left join breweries br
            on b.brewery_id = br.id
            where s.id = ?
            order by beer_name asc;
            """;

    public static final String BREWERY_BEERS = """
            select br.id brewery_id, br.name, br.address1, br.address2, br.city, br.phone, br.website, br.descript description,
            b.id beer_id, b.name beer_name, b.descript beer_description
            from beers b
            left join breweries br
            on b.brewery_id = br.id
            where br.id = ?
            order by beer_name asc;
            """;
}
