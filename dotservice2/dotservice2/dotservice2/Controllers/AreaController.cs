using dotservice2.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace dotservice2.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class AreaController : ControllerBase
    {
        private P19SocialissuedbContext db;

        public AreaController(P19SocialissuedbContext p19SocialissuedbContext)
        {
            this.db = p19SocialissuedbContext;
        }

        [HttpGet]
        public List<Area> GetArea()
        {
            List<Area> areaLst = db.Areas.ToList();
            return areaLst;
        }

        [HttpPost]
        public String AddArea(Area area)
        {
            db.Areas.Add(area);
            db.SaveChanges();
            return "Area Added Successfully!";
        }
        
        [HttpPut("{id}")]
        public String UpdateArea(int id, Area new_area)
        {
            var area = db.Areas.Find(id);
            area.AreaName = new_area.AreaName;
            area.Pincode = new_area.Pincode;
            db.SaveChanges();
            return "Area Updated Successfully!";

        }

        /*
        // PUT: api/Area/5
        [HttpPut("{id}")]
        public async Task<IActionResult> PutArea(int id, Area updatedArea)
        {
            if (id != updatedArea.AreaId)
            {
                return BadRequest("Area ID mismatch");
            }

            var existingArea = await db.Areas.FindAsync(id);

            if (existingArea == null)
            {
                return NotFound("Area not found");
            }

            // Update fields
            existingArea.AreaName = updatedArea.AreaName;
            existingArea.Pincode = updatedArea.Pincode;

            try
            {
                await db.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                return StatusCode(500, "An error occurred while updating the area.");
            }

            return Ok(existingArea);
        }
        */

        [HttpDelete("{id}")]
        public String DeleteArea(int id)
        {
            var obj_area = db.Areas.Find(id);
            db.Remove(obj_area);
            db.SaveChanges();
            return "Area Deleted Successfully!";
        }
    }
}

