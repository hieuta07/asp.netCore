using Manage.Models;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;
namespace Manage.Data
{
   
        public class CompanyContext : DbContext
        {
            public CompanyContext(DbContextOptions<CompanyContext> options) : base(options)
            {
            }

            public DbSet<Department> Departments { get; set; }
            public DbSet<Employee> Employees { get; set; }
        }
    }



