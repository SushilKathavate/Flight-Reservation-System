using FlightManagementAPI.Models;
using Microsoft.AspNetCore.Mvc;
using FlightManagementAPI.Data;
using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace FlightManagementAPI.Controllers
{    
    
    [ApiController]
    [Route("api/[controller]")]
    public class FaresController : ControllerBase
    {
        private readonly ApplicationDbContext _context;

        public FaresController(ApplicationDbContext context)
        {
            _context = context;
        }

        // GET: api/fares
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Fare>>> GetFares()
        {
            return await _context.Fares.Include(f => f.Flight).ToListAsync();
        }

        // GET: api/fares/{id}
        [HttpGet("{id}")]
        public async Task<ActionResult<Fare>> GetFare(int id)
        {
            var fare = await _context.Fares.Include(f => f.Flight).FirstOrDefaultAsync(f => f.Id == id);

            if (fare == null)
            {
                return NotFound();
            }

            return fare;
        }

        // POST: api/fares
        [HttpPost]
        public async Task<ActionResult<Fare>> CreateFare(Fare fare)
        {
            _context.Fares.Add(fare);
            await _context.SaveChangesAsync();

            return CreatedAtAction(nameof(GetFare), new { id = fare.Id }, fare);
        }

        // PUT: api/fares/{id}
        [HttpPut("{id}")]
        public async Task<IActionResult> UpdateFare(int id, Fare fare)
        {
            if (id != fare.Id)
            {
                return BadRequest();
            }

            _context.Entry(fare).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!FareExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // DELETE: api/fares/{id}
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteFare(int id)
        {
            var fare = await _context.Fares.FindAsync(id);
            if (fare == null)
            {
                return NotFound();
            }

            _context.Fares.Remove(fare);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool FareExists(int id)
        {
            return _context.Fares.Any(e => e.Id == id);
        }
    }


}
