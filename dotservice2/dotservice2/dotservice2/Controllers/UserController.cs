using dotservice2.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace dotservice2.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UserController : ControllerBase
    {
        private readonly P19SocialissuedbContext db;

        public UserController(P19SocialissuedbContext p19SocialissuedbContext)
        {
            db = p19SocialissuedbContext;
        }

        [HttpGet]
        public async Task<ActionResult<IEnumerable<object>>> GetUsersWithRoles()
        {
            var users = await db.Users 
                .Include(u => u.RidNavigation)
                .Select(u => new
                {
                    u.Uid,
                    u.Uname,
                    u.Password,
                    u.Email,
                    u.PhoneNo,
                    u.Status,
                    Role = u.RidNavigation != null
                        ? new { u.RidNavigation.Rid, u.RidNavigation.Rname }
                        : null
                })
                .ToListAsync();

            return Ok(users);
        }
 
        [HttpPost]
        public String AddUser(User user)
        {
            db.Users.Add(user);
            db.SaveChanges();
            return "User Added Successfully!";
        }
        
        [HttpPut("{id}")]
        public String UpdateUser(int id, String status)
        {
            var user = db.Users.Find(id);
            //User.Uname = new_user.Uname;
            //User.Password = User.Password;
            //User.Rid = new_user.Rid;
            //User.PhoneNo = new_user.PhoneNo;
            //User.Email = new_user.Email;
            //user.Status = new_user.Status;
            user.Status = status;
            db.SaveChanges();
            return "User Updated Successfully!";

        }

        [HttpDelete("{id}")]
        public String DeleteUser(int id)
        {
            var obj_User = db.Users.Find(id);
            db.Remove(obj_User);
            db.SaveChanges();
            return "User Deleted Successfully!";
        }
    }
}
