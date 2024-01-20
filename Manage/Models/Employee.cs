using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Manage.Models
{
    public class Employee
    {
       
            public int Id { get; set; }
            public string Name { get; set; }
            public string Code { get; set; }
            public string Rank { get; set; }


            public int DepartmentId { get; set; }


            public Department Department { get; set; }
        
    }
}
