namespace model;
using System;
using System.ComponentModel.DataAnnotations;
public class Flight
{
    [Key]
    public int Id { get; set; }
    public string FlightNumber { get; set; }
    public string Destination { get; set; }
    public string Origin { get; set; }
    public DateTime DepartureTime { get; set; }
    public DateTime ArrivalTime { get; set; }
    public int Capacity { get; set; }
    public ICollection<Fare> Fares { get; set; } = new List<Fare>();
    public Flight()
    {
        
    }

    public Flight(int id, string flightnumber, string destination, string origin , DateTime departuretime, DateTime arrivaltime, int capacity)
    {
        this.Id = id;
        this.FlightNumber = flightnumber;
        this.Destination = destination;
        this.Origin = origin;
        this.DepartureTime = departuretime;
        this.ArrivalTime = arrivaltime;
        this.Capacity = capacity;
    }
}
