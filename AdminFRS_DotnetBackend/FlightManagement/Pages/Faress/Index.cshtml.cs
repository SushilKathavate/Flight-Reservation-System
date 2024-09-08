using Data;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.AspNetCore.Mvc.Rendering;
using model;
namespace FlightManagement.Pages.Faress
{
    public class IndexModel : PageModel
   
    {
        private readonly ApplicationDbContext _context;

        public IndexModel(ApplicationDbContext context)
        {
            _context = context;
        }

        [BindProperty]
        public Fare Fare { get; set; }

        public SelectList FlightList { get; set; }

        public void OnGet()
        {
            FlightList = new SelectList(_context.Flights.ToList(), "Id", "FlightNumber");
        }

        public async Task<IActionResult> OnPostAsync()
        {
            if (!ModelState.IsValid)
            {
                FlightList = new SelectList(_context.Flights.ToList(), "Id", "FlightNumber");
                return Page();
            }

            _context.Fares.Add(Fare);
            await _context.SaveChangesAsync();

            return RedirectToPage("Index");
        }
    }

}
