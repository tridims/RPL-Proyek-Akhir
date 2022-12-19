package Model;

import Abstract.CommonUser;

public class User extends CommonUser {
    private Bookmark bookmark;

    public User(Bookmark bookmark) {
        this.bookmark = bookmark;
    }

    @Override
    public boolean logout() {
        return true;
    }

    public boolean addToBookmark(CoworkingSpace cospace){
        return bookmark.insert(cospace);
    }

    public boolean removeFromBookmark(CoworkingSpace cospace) {
        return bookmark.remove(cospace);
    }

    public boolean makeReview(CoworkingSpace cospace, int score, String description) {
        return cospace.makeReview(this, score, description);
    }


}
