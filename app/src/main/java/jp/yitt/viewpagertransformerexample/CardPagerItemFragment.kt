package jp.yitt.viewpagertransformerexample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CardPagerItemFragment : Fragment() {

    companion object {
        val KEY_NUMBER = "number"

        fun newInstance(number: Int): CardPagerItemFragment {
            val fragment = CardPagerItemFragment()
            val args = Bundle()
            args.putInt(KEY_NUMBER, number)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
            = inflater.inflate(R.layout.pager_item_fragment_card, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cardText = view.findViewById(R.id.text_card) as TextView

        val number = arguments.getInt(KEY_NUMBER)

        cardText.text = "item $number"
    }
}