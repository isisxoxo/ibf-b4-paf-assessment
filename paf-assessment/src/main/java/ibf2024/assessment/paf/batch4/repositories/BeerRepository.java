package ibf2024.assessment.paf.batch4.repositories;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import ibf2024.assessment.paf.batch4.models.Beer;
import ibf2024.assessment.paf.batch4.models.Brewery;
import ibf2024.assessment.paf.batch4.models.Style;

@Repository
@RequestMapping
public class BeerRepository implements Queries {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// DO NOT CHANGE THE SIGNATURE OF THIS METHOD
	public List<Style> getStyles() {
		// TODO: Task 2
		List<Style> styleList = new LinkedList<>();

		SqlRowSet rs = jdbcTemplate.queryForRowSet(BEER_STYLE_COUNT);
		while (rs.next()) {
			Style style = new Style();
			style.setStyleId(rs.getInt("id"));
			style.setName(rs.getString("style_name"));
			style.setBeerCount(rs.getInt("cnt_beers"));
			styleList.add(style);
		}
		return styleList;
	}

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public List<Beer> getBreweriesByBeer(int id) {
		// TODO: Task 3
		List<Beer> beerList = new LinkedList<>();

		SqlRowSet rs = jdbcTemplate.queryForRowSet(BEER_BREWERIES, id);
		while (rs.next()) {
			Beer beer = new Beer();
			beer.setBeerId(rs.getInt("beer_id"));
			beer.setBeerName(rs.getString("beer_name"));
			beer.setBeerDescription(rs.getString("beer_description"));
			beer.setBreweryId(rs.getInt("brewery_id"));
			beer.setBreweryName(rs.getString("brewery_name"));
			beerList.add(beer);
		}
		return beerList;
	}

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public Optional<Brewery> getBeersFromBrewery(int id) {
		// TODO: Task 4
		Brewery brewery = new Brewery();

		SqlRowSet rs = jdbcTemplate.queryForRowSet(BREWERY_BEERS, id);
		if (rs.next()) {
			brewery.setBreweryId(rs.getInt("brewery_id"));
			brewery.setName(rs.getString("name"));
			brewery.setAddress1(rs.getString("address1"));
			brewery.setAddress2(rs.getString("address2"));
			brewery.setCity(rs.getString("city"));
			brewery.setPhone(rs.getString("phone"));
			brewery.setWebsite(rs.getString("website"));
			brewery.setDescription(rs.getString("description"));
		} else {
			return Optional.empty();
		}

		List<Beer> beerList = new LinkedList<>();
		while (rs.next()) {
			Beer beer = new Beer();
			beer.setBeerId(rs.getInt("beer_id"));
			beer.setBeerName(rs.getString("beer_name"));
			beer.setBeerDescription(rs.getString("beer_description"));
			beerList.add(beer);
		}

		brewery.setBeers(beerList);
		return Optional.of(brewery);

	}
}
// select br.id brewery_id, br.name, br.address1, br.address2, br.city,
// br.phone, br.website, br.descript description,
// b.id beer_id, b.name beer_name, b.descript beer_description
