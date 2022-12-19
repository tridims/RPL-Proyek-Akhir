package Model;

import Abstract.CommonUser;

public class User extends CommonUser {
    private Bookmark bookmark;

    @Override
    public boolean logout() {
        return true;
    }

    public boolean addToBookmark(CoworkingSpace cospace) {
        return bookmark.insert(cospace);
    }

    public boolean removeFromBookmark(CoworkingSpace cospace) {
        return bookmark.remove(cospace);
    }

//    public boolean makeReview(CoworkingSpace cospace, Review review) {
//
//    }
}
