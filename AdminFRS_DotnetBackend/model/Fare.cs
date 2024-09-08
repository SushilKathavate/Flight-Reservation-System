using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace model;

    public class Fare
    {
        public int Id { get; set; }
        public int FlightId { get; set; }
        public decimal Price { get; set; }
        public string Type { get; set; } // e.g., Economy, Business

        public Flight Flight { get; set; }
    public Fare()
    {
        
    }
    public Fare(int id,int flightid,decimal price,string type)

    {
        this.Id = id;
        this.FlightId = flightid;
        this.Price = price;
        this.Type = type;
    }
}

