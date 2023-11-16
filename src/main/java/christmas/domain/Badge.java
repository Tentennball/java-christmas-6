package christmas.domain;

import christmas.constant.BadgeConstant;

public class Badge {
    int totalDiscountPrice;
    String badgeName;

    public Badge(int totalDiscountPrice) {
        this.totalDiscountPrice = totalDiscountPrice;
        this.badgeName = grantBadgeName();
    }

    public String grantBadgeName(){
        if(totalDiscountPrice>=BadgeConstant.SANTA_BADGE_COST){
            return BadgeConstant.SANTA_BADGE_NAME;
        }
        if(totalDiscountPrice>=BadgeConstant.TREE_BADGE_COST){
            return BadgeConstant.TREE_BADGE_NAME;
        }
        if(totalDiscountPrice>=BadgeConstant.STAR_BADGE_COST){
            return BadgeConstant.STAR_BADGE_NAME;
        }
        return BadgeConstant.NONE_BADGE_NAME;
    }
    
    public String getBadgeName(){
        return badgeName;
    }
}
