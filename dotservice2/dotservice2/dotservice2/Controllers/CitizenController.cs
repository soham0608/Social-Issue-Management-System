using dotservice2.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace dotservice2.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class CitizenController : ControllerBase
    {
        private readonly P19SocialissuedbContext db;

        public CitizenController(P19SocialissuedbContext p19SocialissuedbContext)
        {
            db = p19SocialissuedbContext;
        }

        // GET: api/Citizens
        [HttpGet]
        public async Task<ActionResult<IEnumerable<object>>> GetCitizensWithDetails()
        {
            var citizens = await db.Citizens
                .Include(c => c.Area)
                .Include(c => c.UidNavigation)
                .Select(c => new
                {
                    c.Cid,
                    c.Fname,
                    c.Lname,
                    c.Address,
                    c.Gender,
                    c.Dob,
                    c.AadharNo,
                    Area = new
                    {
                        c.Area.AreaId,
                        c.Area.AreaName,
                        c.Area.Pincode
                    },
                    User = new
                    {
                        c.UidNavigation.Uid,
                        c.UidNavigation.Uname,
                        c.UidNavigation.Email,
                        c.UidNavigation.PhoneNo,
                        c.UidNavigation.Status
                    }
                })
                .ToListAsync();

            return Ok(citizens);
        }
    }
}
