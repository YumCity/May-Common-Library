package cc.zoyn.core.dto;

import cc.zoyn.core.util.BookUtils;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.List;

/**
 * Book - 数据模型
 *
 * @author Zoyn
 */
@Data
@AllArgsConstructor
public class Book {

    private String author = "notch";
    private String title = "HelloWorld";
    private List<Page> pages = Lists.newArrayList();

    public ItemStack getItem() {
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta meta = (BookMeta) book.getItemMeta();
        meta.setTitle(title);
        meta.setAuthor(author);
        BookUtils.setPagesAsPage(meta, pages);
        book.setItemMeta(meta);
        return book;
    }
}
