namespace FlightManagementAPI.Models
{
    public class Fare
    {
        public int Id { get; set; }
        public int FlightId { get; set; }  // Link to a specific flight
        public decimal Amount { get; set; }
        public string Currency { get; set; }
        public Flight Flight { get; set; }
    }

}
