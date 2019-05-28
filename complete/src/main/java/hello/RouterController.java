package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class RouterController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	// Absatz

	@RequestMapping("/absatz")
	public String absatz() {
		return absatz2();
	}

	@RequestMapping("/Absatz")
	public String absatz2() {

		try {
			DBCONNECTOR dbc = new DBCONNECTOR();
			dbc.setup();
			return dbc.get("Absatz");

		} catch (Exception e) {
			return "ERROR";
		}

	}

	// Verkaeufer

	@RequestMapping("/verkaeufer")
	public String verkaeufer() {
		return verkaeufer2();
	}

	@RequestMapping("/Verkaeufer")
	public String verkaeufer2() {

		try {
			DBCONNECTOR dbc = new DBCONNECTOR();
			dbc.setup();
			return dbc.get("Verkaeufer");

		} catch (Exception e) {
			return "ERROR";
		}

	}

	// Kunden

	@RequestMapping("/kunden")
	public String kunden() {
		return kunden2();
	}

	@RequestMapping("/Kunden")
	public String kunden2() {

		try {
			DBCONNECTOR dbc = new DBCONNECTOR();
			dbc.setup();
			return dbc.get("Kunden");

		} catch (Exception e) {
			return "ERROR";
		}

	}

	// Artikel

	@RequestMapping("/artikel")
	public String artikel() {
		return artikel2();
	}

	@RequestMapping("/Artikel")
	public String artikel2() {

		try {
			DBCONNECTOR dbc = new DBCONNECTOR();
			dbc.setup();
			return dbc.get("Artikel");

		} catch (Exception e) {
			return "ERROR";
		}

	}

	// Date

	@RequestMapping("/datum")
	public String date() {
		return date2();
	}

	@RequestMapping("/Datum")
	public String date2() {

		try {
			DBCONNECTOR dbc = new DBCONNECTOR();
			dbc.setup();
			return dbc.get("Datum");

		} catch (Exception e) {
			return "ERROR";
		}

	}

}
