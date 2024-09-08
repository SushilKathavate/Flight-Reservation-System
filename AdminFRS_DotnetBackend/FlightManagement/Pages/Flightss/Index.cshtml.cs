using Data;

using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using model;

namespace FlightManagement.Pages.Flightss
{
    public class IndexModel : PageModel
    {
        private readonly ApplicationDbContext _db;

        public List<Flight> flights { get; set; }

        public IndexModel(ApplicationDbContext db)
        {
            _db = db;
        }
        public void OnGet()
        {
            flights = _db.Flights.ToList();
        }
    }
}
