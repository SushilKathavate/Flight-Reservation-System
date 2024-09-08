using FlightManagementAPI.Models;
using Microsoft.EntityFrameworkCore;

namespace FlightManagementAPI.Data
{
    public class ApplicationDbContext : DbContext
    {
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options)
            : base(options)
        {
        }

        // Define DbSet properties for your entities
        public DbSet<Flight> Flights { get; set; }
        public DbSet<Fare> Fares { get; set; }
        public DbSet<User> Users { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            // Configure Flight-Fare relationship
            modelBuilder.Entity<Fare>()
                .HasOne(f => f.Flight)
                .WithMany(f => f.Fares)
                .HasForeignKey(f => f.FlightId);

            base.OnModelCreating(modelBuilder);
        }
    }

}
