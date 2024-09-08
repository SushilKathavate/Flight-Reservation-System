using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace model;
public class User
{
    public int Id { get; set; }
    public string Username { get; set; }
    public string Email { get; set; }
    public string Role { get; set; } // e.g., Admin, Customer

    public User()
    {
        
    }
    public User(int id, string username, string email, string role)
    {
        this.Id = id;
        this.Username = username;
        this.Email = email;
        this.Role = role;
        
    }
}

