package hack.healthcare.server.utils;

import java.util.Comparator;

import hack.healthcare.server.model.Lekaren;
import hack.healthcare.server.model.ZilinaData;

public class LocationComparator implements Comparator<Lekaren> {

	private ZilinaData origin;

	public LocationComparator(ZilinaData origin) {
		this.origin = origin;
	}

	@Override
	public int compare(Lekaren o1, Lekaren o2) {
		Lekaren l1 =  o1;
		Lekaren l2 =  o2;
		return Double.compare(
				distance(Double.valueOf(l1.getLat()), Double.valueOf(origin.getLat()), Double.valueOf(l1.getLng()),
						Double.valueOf(origin.getLng()), 0, 0),
				distance(Double.valueOf(l2.getLat()), Double.valueOf(origin.getLat()), Double.valueOf(l2.getLng()),
						Double.valueOf(origin.getLng()), 0, 0));
	}

	public static double distance(double lat1, double lat2, double lon1, double lon2, double el1, double el2) {

		final int R = 6371; // Radius of the earth

		double latDistance = Math.toRadians(lat2 - lat1);
		double lonDistance = Math.toRadians(lon2 - lon1);
		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = R * c * 1000; // convert to meters

		double height = el1 - el2;

		distance = Math.pow(distance, 2) + Math.pow(height, 2);

		return Math.sqrt(distance);
	}

}
