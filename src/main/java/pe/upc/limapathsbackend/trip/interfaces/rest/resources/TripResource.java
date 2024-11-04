package pe.upc.limapathsbackend.trip.interfaces.rest.resources;

public record TripResource(
        Long id,
        String origin,
        String destination,
        String time,
        String fare) {
}