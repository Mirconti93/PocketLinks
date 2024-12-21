import com.mircontapp.sportalbum.domain.models.CategoryModel
import com.mircontapp.sportalbum.domain.models.LinkModel
import com.mircontapp.sportalbum.domain.repository.LinksRepository
import javax.inject.Inject

class LinksByCategoryUC @Inject constructor(val linksRepository: LinksRepository) {
    suspend operator fun invoke(categories: List<CategoryModel>) : List<LinkModel> {
        return linksRepository.getAllLinks().filter { link -> categories.any { it in link.categories }}
    }
}