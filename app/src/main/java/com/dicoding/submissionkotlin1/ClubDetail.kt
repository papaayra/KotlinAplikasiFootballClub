package com.dicoding.submissionkotlin1

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class ClubDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val item = intent.getParcelableExtra<ItemData>(MainActivity.PARCELABLE_ITEM_DATA)
        DetailActivityUI(item).setContentView(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return if (item?.itemId == android.R.id.home) {
            finish()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }

    inner class DetailActivityUI(val item: ItemData) : AnkoComponent<ClubDetail> {
        val id_view = 1
        val id_image = 2
        val id_name = 3

        override fun createView(ui: AnkoContext<ClubDetail>) = with(ui) {
            relativeLayout {
                lparams(wrapContent, wrapContent)

                imageView {
                    id = id_image
                    Glide.with(this)
                            .load(item.image)
                            .into(this)
                }.lparams(dip(100), dip(100)) {
                    centerHorizontally()
                    topMargin = dip(100)
                }

                textView {
                    id = id_name
                    text = item.name
                    textSize = 24f
                    setTypeface(null, Typeface.BOLD)
                }.lparams {
                    below(id_image)
                    centerHorizontally()
                }

                textView {
                    padding = dip(16)
                    text = item.desc
                }.lparams {
                    below(id_name)
                }
            }
        }
    }
}
