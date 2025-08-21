using dotservice2.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace dotservice2.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class IssueCategoryController : ControllerBase
    {
        private readonly P19SocialissuedbContext db;
        
        public IssueCategoryController(P19SocialissuedbContext p19SocialissuedbContext)
        {
            db = p19SocialissuedbContext;
        }

        [HttpGet]
        public List<IssueCategory> GetIssueCategory()
        {
            List<IssueCategory> IssueCategoryLst = db.IssueCategories.ToList();
            return IssueCategoryLst;
        }

        [HttpPost]
        public String AddIssueCategory(IssueCategory IssueCategory)
        {
            db.IssueCategories.Add(IssueCategory);
            db.SaveChanges();
            return "IssueCategory Added Successfully!";
        }

        [HttpPut("{id}")]
        public String UpdateIssueCategory(int id, IssueCategory new_IssueCategory)
        {
            var IssueCategory = db.IssueCategories.Find(id);
            IssueCategory.Description = new_IssueCategory.Description;
            db.SaveChanges();
            return "IssueCategory Updated Successfully!";

        }

        [HttpDelete("{id}")]
        public String DeleteIssueCategory(int id)
        {
            var obj_IssueCategory = db.IssueCategories.Find(id);
            db.Remove(obj_IssueCategory);
            db.SaveChanges();
            return "IssueCategory Deleted Successfully!";
        }

    }
}
