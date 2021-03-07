package com.lpc.test.aidl;

import java.util.List;
import com.lpc.test.aidl.Book;

/**
 * 功能:
 * <p>
 * 描述:
 * <p>
 * Created by lipc0113 on 2021/3/6.
 */
interface IBookManager {
    void addBook(in Book book);
    List<Book> getBookList();
}
