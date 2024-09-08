namespace FlightManagementAPI.Models
{
    public class Flight
    {
        
            public int Id { get; set; }
            public string FlightNumber { get; set; }
            public DateTime Departure { get; set; }
            public DateTime Arrival { get; set; }
            public string Origin { get; set; }
            public string Destination { get; set; }
            public int Capacity { get; set; }
            public List<Fare> Fares { get; set; }

    }
}
