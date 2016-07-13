package com.is.see.sugar;

import android.content.Context;

import com.is.see.entity.BizAreas;
import com.is.see.entity.Categories;
import com.is.see.entity.DealDetail;
import com.is.see.entity.DealShops;
import com.is.see.entity.DealsInSearchShops;
import com.is.see.entity.Districts;
import com.is.see.entity.SearchDeals;
import com.is.see.entity.SearchShops;
import com.is.see.entity.ShopDeals;
import com.is.see.entity.ShopInfo;
import com.is.see.entity.ShopsInSearchDeals;
import com.is.see.entity.Subcategories;
import com.is.see.entity.User;
import com.orm.SugarDb;

/**
 * Created by George on 2016/5/21.
 */
public class SugarDBHelper {

    private static volatile SugarDBHelper instance;

    private SugarDBHelper() {

    }

    public  static SugarDBHelper getInstance(){
        if (null == instance) {
            synchronized (SugarDBHelper.class) {
                if (null == instance) {
                    instance = new SugarDBHelper();
                }
            }
        }
        return instance;
    }
    public void initDB(Context context){
        SugarDb sugarDb=new SugarDb(context);
        SchemaGeneratorUtil schemaGeneratorUtil=new SchemaGeneratorUtil(context);
        sugarDb.getDB().execSQL(schemaGeneratorUtil.createTableSQL(BizAreas.class));
        sugarDb.getDB().execSQL(schemaGeneratorUtil.createTableSQL(Categories.class));
        sugarDb.getDB().execSQL(schemaGeneratorUtil.createTableSQL(DealDetail.class));
        sugarDb.getDB().execSQL(schemaGeneratorUtil.createTableSQL(DealShops.class));
        sugarDb.getDB().execSQL(schemaGeneratorUtil.createTableSQL(DealsInSearchShops.class));
        sugarDb.getDB().execSQL(schemaGeneratorUtil.createTableSQL(Districts.class));
        sugarDb.getDB().execSQL(schemaGeneratorUtil.createTableSQL(SearchDeals.class));
        sugarDb.getDB().execSQL(schemaGeneratorUtil.createTableSQL(SearchShops.class));
        sugarDb.getDB().execSQL(schemaGeneratorUtil.createTableSQL(ShopDeals.class));
        sugarDb.getDB().execSQL(schemaGeneratorUtil.createTableSQL(ShopInfo.class));
        sugarDb.getDB().execSQL(schemaGeneratorUtil.createTableSQL(ShopsInSearchDeals.class));
        sugarDb.getDB().execSQL(schemaGeneratorUtil.createTableSQL(Subcategories.class));
        sugarDb.getDB().execSQL(schemaGeneratorUtil.createTableSQL(User.class));
        sugarDb.close();
    }

}
