using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;
using model;

namespace Data
{

    public class ApplicationDbContext : DbContext
    {
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options) : base(options)
        {
        }

        public DbSet<Flight> Flights { get; set; }
        public DbSet<Fare> Fares { get; set; }
        public DbSet<User> Users { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Fare>()
                .HasOne(f => f.Flight)
                .WithMany(f => f.Fares)
                .HasForeignKey(f => f.FlightId);
        }
    }
}
