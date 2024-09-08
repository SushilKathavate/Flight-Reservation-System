using Data;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using model;

namespace FlightManagement.Pages.Faress
{
    public class DetailListModel : PageModel
    {
        private readonly ApplicationDbContext _db;

        public DetailListModel(ApplicationDbContext db)
        {
            _db = db;
        }

        public Flight Flight { get; set; }
        public IList<Fare> Fares { get; set; }

        public async Task<IActionResult> OnGetAsync(int id)
        {
            Flight = await _db.Flights
                .Include(f => f.Fares)
                .FirstOrDefaultAsync(f => f.Id == id);

            if (Flight == null)
            {
                return NotFound();
            }

            Fares = Flight.Fares.ToList();
            return Page();
        }
    }

}
