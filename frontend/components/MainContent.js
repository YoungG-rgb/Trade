import React from 'react';

const MainContent = () => {
    return (
        <div className='mt-[179px]'>
            <h1 className='not-italic font-normal text-[60px] leading-[50px] text-black mb-[25px]'>Find your <br/> dream watch</h1>
            <p className='mb-[30px] not-italic font-normal text-[14px] leading-[28px] text-[#939393]'>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Enim facilisi elementum <br/> commodo ipsum. Aenean aenean adipiscing lect</p>
            <button className='not-italic font-normal text-[14px] leading-[12px] text-white py-[22px] px-[38px] rounded-[5px] bg-[#735CFF]' type='button'>Design Your Watch</button>

            <div className='absolute top-[190px] z-[-1] right-0'>
                <img className='' src="/main/imgMain.png" alt="imgMain"/>
            </div>
        </div>
    );
};

export default MainContent;